<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { PhDesktopTower } from "phosphor-vue";

type Props = {
  item: HardwareDTO;
  selected?: boolean;
};

defineProps<Props>();
</script>

<template>
  <li cursor="pointer">
    <NCard
      hoverable
      size="medium"
      border="hover:primary"
      :class="[{ '!border-primary bg-primary/10': selected }]"
    >
      <div flex="~ gap-6" items="center">
        <ph-desktop-tower
          :size="42"
          text="primary"
          flex="shrink-0"
          weight="duotone"
        />
        <h4 text="lg">{{ item.name }}</h4>
      </div>
    </NCard>
  </li>
</template>
