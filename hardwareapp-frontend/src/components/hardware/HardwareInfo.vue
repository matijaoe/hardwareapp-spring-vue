<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { PhTag } from "phosphor-vue";
type Props = {
  item: HardwareDTO;
};

type Emits = {
  (e: "close"): void;
};

defineProps<Props>();

const emit = defineEmits<Emits>();
</script>

<template>
  <NCard closable @close="emit('close')" size="huge">
    <template #header>
      <p class="text-dark-50 font-mono text-lg">{{ item.code }}</p>
    </template>
    <div class="flex flex-col justify-between h-full gap-6">
      <h2 class="text-3xl lg:text-4xl text-light-900">
        {{ item.name }}
      </h2>
      <div class="ml-auto text-4xl lg:text-5xl flex items-center gap-4">
        <div class="flex items-center">
          <span class="text-[#63e2b7]">$</span>
          <p>{{ item.price }}</p>
        </div>
        <ph-tag :size="52" color="#60ebc9" weight="duotone" />
      </div>
    </div>
  </NCard>
</template>
