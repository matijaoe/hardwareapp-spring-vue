<script setup lang="ts">
import type { Review } from "@/models/review";

type Props = {
  review: Review;
};

defineProps<Props>();
</script>

<template>
  <n-list-item>
    <n-thing :title="review.title" :title-extra="`${review.rating} stars`" />
    <router-link :to="{ name: 'ReviewItem', params: { title: review.title } }">
      go to review
    </router-link>
  </n-list-item>
</template>
