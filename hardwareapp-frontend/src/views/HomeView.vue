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
    <div class="lg:mt-10">
      <n-h1 prefix="bar" type="success" class="mb-8">
        <n-text>Available hardware</n-text>
      </n-h1>
      <div class="flex flex-col-reverse lg:flex-row gap-2 lg:gap-12">
        <HardwareList
          class="w-full lg:max-w-100"
          :items="store.hardware"
          :selected-item="selectedHardware"
          @select="setSelectedHardware"
        />
        <HardwareInfo
          v-if="selectedHardware"
          class="flex-1"
          :item="selectedHardware"
          @close="clearSelectedHardware"
        />
      </div>
    </div>
  </div>
</template>
