<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhShuffle, PhArrowsClockwise } from "phosphor-vue";

import { useHardwareFetch } from "@/composables/hardware/use-hardware-fetch";

const { fetchHardware } = useHardwareFetch();

const store = useHardwareStore();
</script>

<template>
  <div mb="5 sm:6  lg:8" flex="~ gap-4" items="center">
    <n-h2 prefix="bar" type="success" mb="0" text="xl sm:2xl lg:3xl">
      Available hardware
    </n-h2>
    <div flex="~ gap-2" items="center">
      <n-tooltip>
        <template #trigger>
          <n-button type="primary" secondary circle @click="fetchHardware">
            <template #icon>
              <ph-arrows-clockwise />
            </template>
          </n-button>
        </template>
        Refresh
      </n-tooltip>

      <n-tooltip v-if="store.hasHardware">
        <template #trigger>
          <n-button type="info" secondary circle @click="store.shuffleHardware">
            <template #icon>
              <ph-shuffle />
            </template>
          </n-button>
        </template>
        Shuffle
      </n-tooltip>
    </div>
  </div>
</template>
