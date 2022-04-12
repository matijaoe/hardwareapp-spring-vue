<script setup lang="ts">
import { darkTheme } from "naive-ui";
</script>

<template>
  <NConfigProvider :theme="darkTheme">
    <div
      class="bg-background-dark text-light-900 w-screen min-h-screen p-8 font-sans"
    >
      <main class="mx-auto max-w-7xl">
        <RouterView />
      </main>
    </div>
  </NConfigProvider>
</template>

<style>
@import "@/assets/base.css";
</style>
