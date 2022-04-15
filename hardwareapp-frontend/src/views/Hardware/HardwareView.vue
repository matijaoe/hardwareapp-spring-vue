<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhShuffle } from "phosphor-vue";
const store = useHardwareStore();

store.fetchHardware();
</script>

<template>
  <div flex="1 ~ col" h="full">
    <NH1 prefix="bar" type="success" mb="8" flex="~ gap-4" items="center">
      <NText>Available hardware</NText>
      <NButton quaternary circle @click="store.shuffleHardware">
        <template #icon>
          <PhShuffle />
        </template>
      </NButton>
    </NH1>
    <div flex="1 ~ col-reverse lg:row gap-2 lg:gap-12">
      <HardwareList w="full" flex="1" max-w="lg:100" :items="store.hardware" />
    </div>
  </div>
</template>
