<script setup lang="ts">
import { useHardwareReviewsByTitle } from "@/composables/reviews/use-reviews-by-title.1";

const titleQuery = ref("");
const router = useRouter();

const { fetchReviewsByTitle, reviews } = useHardwareReviewsByTitle();

const onInput = () => {
  fetchReviewsByTitle(titleQuery.value);
};
</script>

<template>
  <div>reviews</div>
  <div>
    <input type="text" v-model="titleQuery" @input="onInput" />
    <div v-if="reviews">
      <n-h1>Reviews</n-h1>
      <div v-for="review in reviews" :key="review.id">
        <p @click="router.push(`/reviews/${review.id}`)">{{ review.title }}</p>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped></style>
