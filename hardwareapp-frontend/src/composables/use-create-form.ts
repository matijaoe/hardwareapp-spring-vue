import {
  type HardwareCreate,
  HardwareType,
  type Hardware,
} from "@/models/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { generateAlphanumericId } from "@/utils";
import { set } from "@vueuse/core";
import type { FormInst, FormRules } from "naive-ui";
import { useItemAdd } from "./hardware/use-item-add";

export const useCreateForm = () => {
  const formRef = ref<FormInst | null>(null);
  const codeInputRef = ref<HTMLInputElement | null>(null);

  const store = useHardwareStore();
  const { rules } = useCreateFormRules();

  const modelDefault = (): HardwareCreate => ({
    name: "",
    code: "",
    price: null,
    type: null,
    availableCount: null,
  });

  const model = ref(modelDefault());

  const generateCode = () => {
    set(model.value, "code", generateAlphanumericId());
    codeInputRef.value?.focus();
    codeInputRef.value?.blur();
  };

  const typeOptions = Object.values(HardwareType).map((type) => ({
    label: type,
    value: type,
  }));

  const { createItem, item } = useItemAdd();

  const submitForm = async (e: MouseEvent) => {
    e.preventDefault();
    formRef.value?.validate(async (errors) => {
      if (errors) {
        console.log(errors);
      } else {
        await createItem(model.value as Hardware);
        resetForm();
        await store.fetchHardware();
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
