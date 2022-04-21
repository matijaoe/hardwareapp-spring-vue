<script setup lang="ts">
import { useReviewStore } from "@/stores/reviews";

const store = useReviewStore();

store.fetchReviews();
</script>

<template>
  <div v-if="store.reviews">
    <n-list bordered>
      <template #header> Reviews </template>
      <ReviewItem
        v-for="(review, i) in store.reviews"
        :key="i"
        :review="review"
      />
    </n-list>
  </div>
</template>
