<script setup lang="ts">
import type { ReviewDTO } from "@/models/review";
import { PhStar } from "phosphor-vue";

type Props = {
  review: ReviewDTO;
};

defineProps<Props>();
const iconWeight = (rating: number, n: number) => {
  return rating >= n ? "fill" : "regular";
};
</script>

<template>
  <n-list-item>
    <div flex="~ gap-4" justify="between">
      <h4 text="lg" m="b-2">{{ review.title }}</h4>
      <div flex="~ gap-1" text="lg yellow-500">
        <PhStar
          v-for="n in 5"
          :key="n"
          :weight="iconWeight(review.rating, n)"
        />
      </div>
    </div>
    <n-thing>
      <p opacity="85">{{ review.text }}</p>
    </n-thing>
  </n-list-item>
</template>

<style lang="scss" scoped></style>
