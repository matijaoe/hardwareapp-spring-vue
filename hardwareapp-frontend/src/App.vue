<script setup lang="ts">
import { darkTheme } from "naive-ui";
</script>

<template>
  <n-config-provider :theme="darkTheme">
    <n-notification-provider>
      <n-message-provider>
        <div
          min-h="screen"
          bg="background-dark"
          font="sans"
          text="light-900"
          flex="~ col"
        >
          <div
            px="4 md:6 lg:8"
            py="6"
            w="screen"
            max-w="7xl"
            mx="auto"
            flex="1 ~ col gap-4"
          >
            <AppNav />
            <main flex="~ col 1">
              <RouterView />
            </main>
          </div>
        </div>
      </n-message-provider>
    </n-notification-provider>
  </n-config-provider>
</template>

<style>
@import "@/assets/reset.scss";
@import "@/assets/base.scss";
</style>
