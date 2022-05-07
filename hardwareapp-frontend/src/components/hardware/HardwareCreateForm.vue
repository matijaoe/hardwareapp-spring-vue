<script setup lang="ts">
import { useCreateForm } from "@/composables/use-create-form";
import {
  PhArrowCounterClockwise,
  PhCurrencyDollar,
  PhFingerprintSimple,
  PhIdentificationCard,
  PhPackage,
  PhPlusCircle,
} from "phosphor-vue";

const {
  model,
  rules,
  typeOptions,
  generateCode,
  submitForm,
  resetForm,
  formRef,
  codeInputRef,
} = useCreateForm();
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
          <n-input
            v-model:value="model.code"
            @keydown.enter.prevent
            ref="codeInputRef"
          >
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
          :min="5"
          :step="1"
        >
          <template #prefix>
            <ph-currency-dollar weigth="bold" size="18" mr="1.5" />
          </template>
        </n-input-number>
      </n-form-item>

      <n-form-item path="quantity" label="Available count" flex="1">
        <n-input-number
          v-model:value="model.quantity"
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
