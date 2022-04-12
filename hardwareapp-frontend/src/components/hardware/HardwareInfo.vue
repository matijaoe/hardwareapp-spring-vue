<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { formatNumber } from "@/utils";
import { PhTag } from "phosphor-vue";

type Props = {
  item: HardwareDTO;
};

type Emits = {
  (e: "close"): void;
};

const props = defineProps<Props>();

const emit = defineEmits<Emits>();

const formattedPrice = computed(() => formatNumber(props.item.price));
</script>

<template>
  <NCard closable @close="emit('close')" size="huge">
    <template #header>
      <p text="md md:lg dark-50" font="mono">{{ item.code }}</p>
    </template>
    <div h="full" flex="~ col gap-8" justify="between" mt="-3 lg:-2">
      <h2 text="xl lg:3xl lg:4xl light-900">
        {{ item.name }}
      </h2>
      <div
        class="ml-auto text-3xl lg:text-5xl flex items-center gap-2 lg:gap-4"
      >
        <div flex="~" items="center">
          <span text="primary ">$</span>
          <p font="mono">{{ formattedPrice }}</p>
        </div>
        <ph-tag text="primary" weight="duotone" />
      </div>
    </div>
  </NCard>
</template>
