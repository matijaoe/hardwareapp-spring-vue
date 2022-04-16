<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { formatNumber } from "@/utils";
import { PhTag } from "phosphor-vue";

type Props = {
  item: HardwareDTO;
};

const props = defineProps<Props>();

const formattedPrice = computed(() => formatNumber(props.item.price));
</script>

<template>
  <n-card size="huge">
    <template #header>
      <p text="md md:lg dark-50" font="mono">{{ item.code }}</p>
    </template>
    <div h="full" flex="~ col gap-24" justify="between" mt="-3 lg:-2">
      <div>
        <h2 text="xl lg:4xl light-900">
          {{ item.name }}
        </h2>
      </div>
      <div
        class="ml-auto text-3xl lg:text-4xl flex items-center gap-2 lg:gap-3"
      >
        <div flex="~ gap-1" items="center">
          <span text="primary ">$</span>
          <p font="mono">{{ formattedPrice }}</p>
        </div>
        <ph-tag text="primary" weight="duotone" />
      </div>
    </div>
  </n-card>
</template>
