<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { set } from "@vueuse/core";

const store = useHardwareStore();

const selectedHardware = ref<HardwareDTO | null>(null);

const setSelectedHardware = (code: string) => {
  const hardware = store.getHardwareByCode(code);
  set(selectedHardware, hardware);
};

const clearSelectedHardware = () => set(selectedHardware, null);
</script>

<template>
  <div>
    <div m="lg:t-10">
      <n-h1 prefix="bar" type="success" mb="8">
        <n-text>Available hardware</n-text>
      </n-h1>
      <div flex="~ col-reverse lg:row gap-2 lg:gap-12">
        <HardwareList
          w="full"
          max-w="lg:100"
          :items="store.hardware"
          :selected-item="selectedHardware"
          @select="setSelectedHardware"
        />
        <HardwareInfo
          v-if="selectedHardware"
          flex="1"
          :item="selectedHardware"
          @close="clearSelectedHardware"
        />
      </div>
    </div>
  </div>
</template>
