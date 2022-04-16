<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhShuffle, PhArrowsClockwise, PhXCircle } from "phosphor-vue";

const store = useHardwareStore();

store.fetchHardware();
</script>

<template>
  <div flex="1 ~ col" h="full">
    <div mb="5 sm:6  lg:8" flex="~ gap-4" items="center">
      <n-h2 prefix="bar" type="success" mb="0" text="xl sm:2xl lg:3xl"
        >Available hardware</n-h2
      >
      <div flex="~ gap-2" items="center">
        <n-tooltip>
          <template #trigger>
            <n-button
              type="primary"
              secondary
              circle
              @click="store.fetchHardware"
            >
              <template #icon>
                <ph-arrows-clockwise />
              </template>
            </n-button>
          </template>
          Refresh
        </n-tooltip>

        <n-tooltip v-if="store.hasHardware">
          <template #trigger>
            <n-button
              type="info"
              secondary
              circle
              @click="store.shuffleHardware"
            >
              <template #icon>
                <ph-shuffle />
              </template>
            </n-button>
          </template>
          Shuffle
        </n-tooltip>
      </div>
    </div>
    <div flex="1 ~ col-reverse gap-2 lg:(row gap-12)" max-w="lg:100">
      <HardwareList
        v-if="store.hasHardware"
        w="full"
        flex="1"
        max-w=""
        :items="store.hardware"
      />
      <div v-else w="full">
        <n-alert title="No hardware found" type="error">
          <template #icon>
            <ph-x-circle weight="fill" />
          </template>
          List of hardware is empty.
        </n-alert>
      </div>
    </div>
  </div>
</template>
