<script setup lang="ts">
import { HardwareType, type HardwareCreate } from "@/models/hardware";
import type { FormInst, FormRules } from "naive-ui";
import {
  PhFingerprintSimple,
  PhCurrencyDollar,
  PhIdentificationCard,
  PhPackage,
  PhPlusCircle,
  PhArrowCounterClockwise,
} from "phosphor-vue";
import { generateAlphanumericId } from "@/utils";
import { set } from "@vueuse/core";

const formRef = ref<FormInst | null>(null);

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
};

const typeOptions = Object.values(HardwareType).map((type) => ({
  label: type,
  value: type,
}));

const rules: FormRules = {
  name: [
    {
      required: true,
      message: "Hardware name is required",
      trigger: ["input", "blur"],
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

const submitForm = (e: MouseEvent) => {
  e.preventDefault();
  formRef.value?.validate((errors) => {
    console.log(errors);
  });
};

const resetForm = (e: MouseEvent) => {
  e.preventDefault();
  formRef.value?.restoreValidation();
  set(model, modelDefault());
};
</script>

<template>
  <n-card size="medium">
    <n-form
      ref="formRef"
      :model="model"
      :rules="rules"
      size="large"
      label-placement="top"
      show-require-mark
    >
      <n-form-item path="code" label="Code">
        <n-input-group>
          <n-input v-model:value="model.code" @keydown.enter.prevent>
            <template #prefix>
              <ph-fingerprint-simple weigth="bold" size="18" mr="1.5" />
            </template>
          </n-input>
          <n-button type="primary" @click="generateCode"> Generate </n-button>
        </n-input-group>
      </n-form-item>

      <n-form-item path="name" label="Name">
        <n-input v-model:value="model.name" @keydown.enter.prevent>
          <template #prefix>
            <ph-identification-card weigth="bold" size="18" mr="1.5" />
          </template>
        </n-input>
      </n-form-item>

      <n-form-item label="Type" path="type">
        <n-radio-group v-model:value="model.type" name="type">
          <n-radio-button
            v-for="{ value, label } in typeOptions"
            :key="value"
            :value="value"
          >
            {{ label }}
          </n-radio-button>
        </n-radio-group>
      </n-form-item>

      <n-form-item path="price" label="Price" flex="1">
        <n-input-number
          v-model:value="model.price"
          @keydown.enter.prevent
          min="0.5"
          step="1"
        >
          <template #prefix>
            <ph-currency-dollar weigth="bold" size="18" mr="1.5" />
          </template>
        </n-input-number>
      </n-form-item>

      <n-form-item path="availableCount" label="Available count" flex="1">
        <n-input-number
          v-model:value="model.availableCount"
          @keydown.enter.prevent
          step="1"
          :min="0"
          :max="1000"
        >
          <template #prefix>
            <ph-package weigth="bold" size="18" mr="1.5" />
          </template>
        </n-input-number>
      </n-form-item>
      <div flex="~ gap-3" class="mt-2">
        <n-button type="primary" @click="submitForm">
          <template #icon>
            <ph-plus-circle weight="duotone" />
          </template>
          Add hardware
        </n-button>
        <n-button type="primary" secondary @click="resetForm">
          <template #icon>
            <ph-arrow-counter-clockwise weight="bold" />
          </template>
          Reset
        </n-button>
      </div>
    </n-form>
  </n-card>
</template>

<style lang="scss" scoped></style>
