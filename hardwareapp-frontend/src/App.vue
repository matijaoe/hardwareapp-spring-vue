<script setup lang="ts">
import { darkTheme } from "naive-ui";
</script>

<template>
  <NConfigProvider :theme="darkTheme">
    <div
      bg="background-dark"
      font="sans"
      text="light-900"
      w="screen"
      min-h="screen"
      px="4 md:6 lg:8"
      py="6 lg:8"
    >
      <main mx="auto" max-w="7xl">
        <RouterView />
      </main>
    </div>
  </NConfigProvider>
</template>

<style>
@import "@/assets/base.css";
</style>
