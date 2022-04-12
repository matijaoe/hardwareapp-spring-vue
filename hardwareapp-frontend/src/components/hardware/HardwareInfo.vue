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
      <p text="lg dark-50" font="mono">{{ item.code }}</p>
    </template>
    <div h="full" flex="~ col gap-6" justify="between">
      <h2 text="3xl lg:4xl light-900">
        {{ item.name }}
      </h2>
      <div class="ml-auto text-4xl lg:text-5xl flex items-center gap-4">
        <div flex="~" items="center">
          <span text="primary ">$</span>
          <p font="mono">{{ item.price }}</p>
        </div>
        <ph-tag :size="42" text="primary" weight="duotone" />
      </div>
    </div>
  </NCard>
</template>
