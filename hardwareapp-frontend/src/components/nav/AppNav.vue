<script setup lang="ts">
const router = useRouter();
</script>

<template>
  <div class="flex justify-between lg:grid lg:grid-cols-3">
    <NButton text @click="router.push({ name: 'Home' })" class="col-start-2">
      <NH1 font="sans" text="hover:primary">Hardwareapp</NH1>
    </NButton>
    <NButton
      class="col-span-1"
      strong
      secondary
      type="primary"
      justify="self-end"
      @click="router.push({ name: 'Hardware' })"
    >
      Hardware
    </NButton>
  </div>
</template>

<style lang="scss" scoped></style>
