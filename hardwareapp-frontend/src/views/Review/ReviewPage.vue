<script setup lang="ts">
import { useReviewById } from "@/composables/reviews/use-review-by-id";

const route = useRoute();

const { fetchReview, review } = useReviewById();
console.log("route.params.id :>> ", route.params.id);
watchEffect(async () => {
  if (route.params.id) {
    const id = route.params.id as string;
    await fetchReview(id);
  }
});
console.log("hi");
</script>

<template>
  <div>review</div>
  <div v-if="review">
    {{ review }}
  </div>
</template>

<style lang="scss" scoped></style>
