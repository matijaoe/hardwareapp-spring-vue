<script setup lang="ts">
import type { ReviewDTO } from "@/models/review";
import { PhXCircle } from "phosphor-vue";
type Props = {
  reviews: ReviewDTO[];
  loading: boolean;
};

const props = defineProps<Props>();

const hasReviews = computed(() => props.reviews?.length > 0);
</script>

<template>
  <n-list v-if="hasReviews" bordered>
    <template #header>
      <n-h3 mb="0" class="uppercase">Reviews</n-h3>
    </template>
    <HardwareReview
      v-for="review in reviews"
      :key="review.id"
      :review="review"
    />
  </n-list>
  <n-alert
    v-else-if="!loading"
    title="No reviews found"
    type="default"
    weight="fill"
  >
    <template #icon>
      <ph-x-circle weight="fill" />
    </template>
    <p>
      There are no reviews for this hardware yet. Be the first to review it.
    </p>
  </n-alert>
</template>
