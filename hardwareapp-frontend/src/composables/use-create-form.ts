import {
  type HardwareCreate,
  HardwareType,
  type Hardware,
  type HardwareDTO,
} from "@/models/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { generateAlphanumericId } from "@/utils";
import { set } from "@vueuse/core";
import {
  NButton,
  useMessage,
  useNotification,
  type FormInst,
  type FormRules,
} from "naive-ui";
import { useItemAdd } from "./hardware/use-item-add";

export const useCreateForm = () => {
  const formRef = ref<FormInst | null>(null);
  const codeInputRef = ref<HTMLInputElement | null>(null);

  const store = useHardwareStore();
  const { rules } = useCreateFormRules();
  const { createItem, item } = useItemAdd();

  const message = useMessage();
  const { showItemCreatedNotification } = useItemCreateFormNotifications();

  const modelDefault = (): HardwareCreate => ({
    name: "",
    code: "",
    price: null,
    type: null,
    availableCount: null,
  });

  const model = ref(modelDefault());

  const typeOptions = Object.values(HardwareType).map((type) => ({
    label: type,
    value: type,
  }));

  const generateCode = () => {
    set(model.value, "code", generateAlphanumericId());
    codeInputRef.value?.focus();
    codeInputRef.value?.blur();
  };

  const submitForm = async (e: MouseEvent) => {
    e.preventDefault();
    formRef.value?.validate(async (errors) => {
      if (errors) {
        console.log(errors);
        message.error("Check your data and try again.");
      } else {
        await createItem(model.value as Hardware);
        if (item.value?.code) {
          message.destroyAll();
          message.success("Item created");
          showItemCreatedNotification(item.value);
          resetForm();
          await store.fetchHardware();
        } else {
          message.error("Something went wrong creating the hardware");
        }
      }
    });
  };

  const resetForm = (e?: MouseEvent) => {
    e?.preventDefault();
    formRef.value?.restoreValidation();
    set(model, modelDefault());
  };

  return {
    modelDefault,
    model,
    typeOptions,
    rules,
    formRef,
    codeInputRef,
    generateCode,
    submitForm,
    resetForm,
  };
};

export const useCreateFormRules = () => {
  const rules: FormRules = {
    name: [
      {
        required: true,
        message: "Hardware name is required",
        trigger: ["input", "blur", "change"],
      },
      {
        min: 4,
        message: "Name should be at least 4 characters",
        trigger: ["input", "blur"],
      },
    ],
    code: [
      {
        required: true,
        message: "Hardware code is required",
        trigger: ["input", "blur"],
      },
      {
        min: 6,
        message: "Code should be at least 6 characters",
        trigger: ["input", "blur"],
      },
    ],
    type: [
      {
        required: true,
        enum: Object.values(HardwareType),
        type: "enum",
        message: "Hardware type is required",
        trigger: ["input", "blur"],
      },
    ],
    price: [
      {
        type: "number",
        required: true,
        message: "Hardware price is required",
        trigger: ["input", "blur"],
      },
    ],
    availableCount: [
      {
        type: "number",
        required: true,
        message: "Available count is required",
        trigger: ["input", "blur"],
      },
    ],
  };

  return {
    rules,
  };
};

const useItemCreateFormNotifications = () => {
  const router = useRouter();
  const notification = useNotification();

  const showItemCreatedNotification = (item: HardwareDTO) => {
    const n = notification.success({
      title: "Item created",
      content: `You have successfully added ${item.name} to your list of hardware.`,
      action: () =>
        h(
          NButton,
          {
            type: "primary",
            onClick: () => {
              if (item.code) {
                router.push({
                  name: "HardwareItem",
                  params: { code: item.code },
                });
              }
              n.destroy();
            },
          },
          { default: () => "Go to item" }
        ),
      onClose: () => n.destroy(),
    });
  };

  return {
    showItemCreatedNotification,
  };
};
