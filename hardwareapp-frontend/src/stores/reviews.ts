import type { Review } from "@/models/review";
import { set } from "@vueuse/core";
import { getAllReviews, getReviewByTitle } from "@/services/reviews";

export const useReviewStore = defineStore("reviews", () => {
  const reviews = ref<Review[]>([]);

  const hasReviews = computed(() => reviews.value?.length > 0);

  const fetchReviews = async () => {
    try {
      const data = await getAllReviews();
      set(reviews, data ?? []);
    } catch (err: any) {
      console.error(err.message, err);
      set(reviews, []);
    }
  };

  const fetchReview = async (title: string) => {
    try {
      const r = await getReviewByTitle(title);
      console.log("r :>> ", r);
      return r;
    } catch (err: any) {
      console.error(err.message, err);
    }
  };

  return {
    reviews,
    hasReviews,
    fetchReviews,
    fetchReview,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useReviewStore, import.meta.hot));
