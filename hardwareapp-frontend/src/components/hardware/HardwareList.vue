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
  <ul class="flex flex-col gap-2">
    <HardwareListItem
      v-for="item in items"
      :key="item.code"
      :item="item"
      :selected="selectedItem?.code === item.code"
      @click="emit('select', item.code)"
    />
  </ul>
</template>
