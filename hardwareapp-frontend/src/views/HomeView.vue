<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";
import { useHardwareStore } from "@/stores/hardware";
import { set } from "@vueuse/core";

const store = useHardwareStore();
const selectedHardware = ref<HardwareDTO | null>(null);

store.fetchHardware();

const setSelectedHardware = (code: string) => {
  const hardware = store.getHardwareByCode(code);
  set(selectedHardware, hardware);
};

const clearSelectedHardware = () => set(selectedHardware, null);
</script>

<template>
  <div m="lg:t-10">
    <NH1 prefix="bar" type="success" mb="8">
      <NText>Available hardware</NText>
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
        <div flex="~ col gap-2" w="full" v-if="selectedHardware">
          <HardwareDetails
            flex="1"
            :item="selectedHardware"
            @close="clearSelectedHardware"
          />
          <HardwarePriceMessage :price="selectedHardware.price" />
        </div>
      </TheTransition>
    </div>
  </div>
</template>
