<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";

const store = useHardwareStore();

store.fetchHardware();
</script>

<template>
  <div flex="1 ~ col" h="full">
    <HardwareViewHeader />
    <div
      flex="1 ~ col-reverse gap-4 lg:(row gap-8) "
      max-h="lg:70vh xl:74vh 2xl:77vh 3xl:80vh"
      overflow="hidden"
    >
      <HardwareViewAside
        flex="1 ~ gap-2 lg:(row gap-12)"
        max-w="lg:100"
        max-h="lg:70vh xl:74vh 2xl:77vh 3xl:80vh"
      />
      <HardwareViewForm flex="1" />
    </div>
  </div>
</template>
