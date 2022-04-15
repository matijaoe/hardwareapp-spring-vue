<script setup lang="ts"></script>

<template>
  <TheTransition name="fade-slide">
    <div>hardware item</div>
    <!-- <div flex="~ col gap-2" w="full" v-if="selectedHardware">
      <HardwareDetails
        flex="1"
        :item="selectedHardware"
        @close="clearSelectedHardware"
      />
      <HardwarePriceMessage :price="selectedHardware.price" />
    </div> -->
  </TheTransition>
</template>
