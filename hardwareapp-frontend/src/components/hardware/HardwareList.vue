<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";

type Props = {
  items: HardwareDTO[];
  selectedItem: HardwareDTO | null;
};

type Emits = {
  (e: "select", code: string): void;
};

defineProps<Props>();

const emit = defineEmits<Emits>();
</script>

<template>
  <ul flex="~ col gap-2" max-h="75vh" pr="2" overflow="auto">
    <HardwareListItem
      v-for="item in items"
      :key="item.code"
      :item="item"
      :selected="selectedItem?.code === item.code"
      @click="emit('select', item.code)"
    />
  </ul>
</template>
