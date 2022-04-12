<script setup lang="ts">
import type { TransitionName } from "@/models/elements";

type Props = {
  name: TransitionName;
};

defineProps<Props>();
</script>

<template>
  <Transition :name="name" mode="out-in">
    <slot />
  </Transition>
</template>

<style lang="scss">
.fade {
  &-enter-active,
  &-leave-active {
    transition: opacity 200ms ease-out;
  }

  &-enter-from {
    opacity: 0;
  }

  &-leave-to {
    opacity: 0;
  }
}

.fade-slide {
  &-enter-active,
  &-leave-active {
    transition: all 200ms ease-out;
  }

  &-enter-from {
    opacity: 0;
    transform: translateX(-2rem);
  }

  &-leave-to {
    opacity: 0;
    transform: translateX(0.5rem);
  }
}

.fade-down {
  &-enter-active,
  &-leave-active {
    transition: all 200ms ease-out;
  }

  &-enter-from {
    opacity: 0;
    transform: translateY(-1rem);
  }

  &-leave-to {
    opacity: 0;
  }
}
.fade-up {
  &-enter-active,
  &-leave-active {
    transition: all 200ms ease-out;
  }

  &-enter-from {
    opacity: 0;
    transform: translateY(1rem);
  }

  &-leave-to {
    opacity: 0;
  }
}
</style>
