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
  <NPopconfirm @positive-click="emit('confirm')">
    <template #trigger>
      <slot />
    </template>
    <template #icon>
      <PhWarning :color="vars.errorColor" weight="fill" />
    </template>
    <slot name="content">Delete this item?</slot>
  </NPopconfirm>
</template>
