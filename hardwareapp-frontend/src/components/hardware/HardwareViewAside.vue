<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhXCircle } from "phosphor-vue";

const store = useHardwareStore();
</script>

<template>
  <n-scrollbar
    p="r-2"
    flex="1 ~ col-reverse gap-2 lg:(row gap-12)"
    max-w="lg:100"
  >
    <HardwareList
      v-if="store.hasHardware"
      w="full"
      flex="1"
      pr="2"
      :items="store.hardware"
    />
    <n-alert v-else title="No hardware found" type="error" w="full">
      <template #icon>
        <ph-x-circle weight="fill" />
      </template>
      List of hardware is empty.
    </n-alert>
  </n-scrollbar>
</template>

<style lang="scss" scoped></style>
