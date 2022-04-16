<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import { PhShuffle, PhArrowsClockwise, PhXCircle } from "phosphor-vue";

const store = useHardwareStore();

store.fetchHardware();
</script>

<template>
  <div flex="1 ~ col" h="full">
    <NH1 prefix="bar" type="success" mb="8" flex="~ gap-4" items="center">
      <NText>Available hardware</NText>
      <div flex="~ gap-1" items="center">
        <NButton type="primary" secondary circle @click="store.fetchHardware">
          <template #icon>
            <PhArrowsClockwise />
          </template>
        </NButton>
        <NButton
          v-if="store.hasHardware"
          type="info"
          secondary
          circle
          @click="store.shuffleHardware"
        >
          <template #icon>
            <PhShuffle />
          </template>
        </NButton>
      </div>
    </NH1>
    <div flex="1 ~ col-reverse lg:row gap-2 lg:gap-12" max-w="lg:100">
      <HardwareList
        v-if="store.hasHardware"
        w="full"
        flex="1"
        max-w=""
        :items="store.hardware"
      />
      <div v-else w="full">
        <NAlert title="No hardware found" type="error">
          <template #icon>
            <PhXCircle weight="fill" />
          </template>
          List of hardware is empty.
        </NAlert>
      </div>
    </div>
  </div>
</template>
