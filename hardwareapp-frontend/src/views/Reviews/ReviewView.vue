<script setup lang="ts">
import type { Review } from "@/models/review";
import { useReviewStore } from "@/stores/reviews";

const store = useReviewStore();

const route = useRoute();

const review = ref<Review>();

watchEffect(async () => {
  if (route.params.title) {
    review.value = await store.fetchReview(route.params.title as string);
  }
});
</script>

<template>
  <div>
    <h1>Single review</h1>
    <div v-if="review">
      <n-card title="Card" v-if="review">
        <h1>{{ review.title }}</h1>
        <p text="xl">Rating: {{ review.rating }} stars</p>
        <p text="xl">{{ review.text }}</p>
      </n-card>
    </div>
  </div>
</template>
