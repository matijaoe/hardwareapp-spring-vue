<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";

const store = useHardwareStore();

store.fetchHardware();
</script>

<template>
  <div flex="1 ~ col" h="full">
    <NH1 prefix="bar" type="success" mb="8">
      <NText>Available hardware</NText>
    </NH1>
    <div flex="1 ~ col-reverse lg:row gap-2 lg:gap-12">
      <HardwareList w="full" flex="1" max-w="lg:100" :items="store.hardware" />
    </div>
  </div>
</template>
