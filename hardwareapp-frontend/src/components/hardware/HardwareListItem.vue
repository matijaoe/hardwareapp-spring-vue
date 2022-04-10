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
  <li class="cursor-pointer">
    <NCard
      hoverable
      size="medium"
      class="hover:border-[#63e2b7] group"
      :class="[{ '!border-[#63e2b7] bg-[#63e2b7]/10': selected }]"
    >
      <div class="flex gap-6 items-center">
        <PhDesktopTower
          :size="42"
          class="text-[#63e2b7] flex-shrink-0"
          weight="duotone"
        />
        <h4 class="text-lg">{{ item.name }}</h4>
      </div>
    </NCard>
  </li>
</template>
