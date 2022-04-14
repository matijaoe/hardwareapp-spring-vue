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
  <div m="lg:t-10">
    <NH1 prefix="bar" type="success" mb="8">
      <div class="flex justify-between">
        <NText>Available hardware</NText>
        <HardwarePriceMessage
          class="text-primary"
          v-if="selectedHardware"
          :price="selectedHardware.price"
        />
      </div>
    </NH1>
    <div flex="~ col-reverse lg:row gap-2 lg:gap-12">
      <HardwareList
        w="full"
        max-w="lg:100"
        :items="store.hardware"
        :selected-item="selectedHardware"
        @select="setSelectedHardware"
      />

      <TheTransition name="fade-slide">
        <HardwareInfo
          v-if="selectedHardware"
          flex="1"
          :item="selectedHardware"
          @close="clearSelectedHardware"
        />
      </TheTransition>
    </div>
  </div>
</template>
