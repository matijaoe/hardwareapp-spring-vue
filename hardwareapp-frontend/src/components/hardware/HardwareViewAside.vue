<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhXCircle } from "phosphor-vue";

const store = useHardwareStore();
</script>

<template>
  <n-scrollbar
    p="r-4"
    flex="1 ~ col-reverse gap-2 lg:(row gap-12)"
    max-w="lg:100"
  >
    <HardwareList
      v-if="store.hasHardware"
      :items="store.hardware"
      w="full"
      flex="1"
    />
    <div v-else-if="store.loading" flex="1 ~ col" space="y-2">
      <n-skeleton v-for="n in 7" :key="n" height="82px" :sharp="false" />
    </div>
    <n-alert v-else title="No hardware found" type="error" w="full">
      <template #icon>
        <ph-x-circle weight="fill" />
      </template>
      List of hardware is empty.
    </n-alert>
  </n-scrollbar>
</template>
