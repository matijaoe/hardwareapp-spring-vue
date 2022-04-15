<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";

type Props = {
  items: HardwareDTO[];
};

type Emits = {
  (e: "select", item: HardwareDTO): void;
};

defineProps<Props>();

const emit = defineEmits<Emits>();
</script>

<template>
  <ul flex="~ col gap-2" max-h="lg:75vh" pr="2" overflow="auto">
    <HardwareListItem
      v-for="item in items"
      :key="item.code"
      :item="item"
      @click="emit('select', item)"
    />
  </ul>
</template>
