<script setup lang="ts">
import { useThemeVars } from "naive-ui";
import { PhWarning } from "phosphor-vue";

type Emits = {
  (e: "confirm"): void;
};

const emit = defineEmits<Emits>();

const vars = useThemeVars();
</script>

<template>
  <n-popconfirm @positive-click="emit('confirm')">
    <template #trigger>
      <slot />
    </template>
    <template #icon>
      <ph-warning :color="vars.errorColor" weight="fill" />
    </template>
    <slot name="content">Delete this item?</slot>
  </n-popconfirm>
</template>
