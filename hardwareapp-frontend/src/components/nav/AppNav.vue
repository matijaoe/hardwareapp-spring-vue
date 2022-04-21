<script setup lang="ts">
import { PhDesktopTower } from "phosphor-vue";

const router = useRouter();
</script>

<template>
  <div class="flex justify-between lg:(grid grid-cols-3)">
    <n-button text @click="router.push({ name: 'Home' })" class="col-start-2">
      <n-h1 font="sans" text="hover:primary">Hardwareapp</n-h1>
    </n-button>
    <div flex="~ gap-2" items="center" justify="end">
      <n-button
        class="col-span-1"
        strong
        secondary
        type="primary"
        justify="self-end"
        @click="router.push({ name: 'Reviews' })"
      >
        Reviews
      </n-button>
      <n-button
        class="col-span-1"
        strong
        secondary
        type="primary"
        justify="self-end"
        @click="router.push({ name: 'Hardware' })"
      >
        <template #icon> <ph-desktop-tower weight="bold" /> </template>
        Hardware
      </n-button>
    </div>
  </div>
</template>
