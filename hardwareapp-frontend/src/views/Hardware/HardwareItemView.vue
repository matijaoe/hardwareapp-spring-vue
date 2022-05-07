<script setup lang="ts">
import { useItemDelete } from "@/composables/hardware/use-item-delete";
import { useItemFetch } from "@/composables/hardware/use-item-fetch";
import { useHardwareReviews } from "@/composables/reviews/use-review";
import { PhX } from "phosphor-vue";

const router = useRouter();
const route = useRoute();

const { fetchItem, item, loading: fetching } = useItemFetch();
const { deleteItem, loading, isDeleted } = useItemDelete();

const gotoHardware = () => router.push({ name: "Hardware" });

const deleteItemHandler = async () => {
  if (item.value) {
    await deleteItem(item.value?.code);
    if (isDeleted) {
      gotoHardware();
    }
  }
};

const { loading: reviewsLoading, reviews, fetchReviews } = useHardwareReviews();

watchEffect(async () => {
  if (route.params.code) {
    const code = route.params.code as string;
    await Promise.all([fetchItem(code), fetchReviews(code)]);
  }
});
</script>

<template>
  <div flex="1 ~ col gap-3" w="full">
    <template v-if="item">
      <div flex="~ gap-4" justify="between">
        <div flex="~ gap-2">
          <n-button @click="gotoHardware">Go back</n-button>
        </div>

        <PopConfirmDelete @confirm="deleteItemHandler">
          <n-button class="visible" type="error" secondary>
            <template #icon>
              <ph-x weight="bold" />
            </template>
            Delete
          </n-button>
        </PopConfirmDelete>
      </div>
      <n-spin :show="loading">
        <div flex="~ col-reverse lg:row gap-4">
          <HardwareDetails :item="item" />
          <HardwarePriceMessage :price="item.price" class="lg:flex-[600px]" />
        </div>
      </n-spin>
    </template>
    <div
      v-else-if="!fetching"
      class="grid place-content-center -translate-y-[8vh]"
      flex="1"
    >
      <n-result
        status="404"
        title="Item not found"
        description="Gone but not forgotten"
      >
        <template #footer>
          <n-button @click="gotoHardware">Find something else</n-button>
        </template>
      </n-result>
    </div>
    <div v-if="reviewsLoading">Reviews Loading...</div>
    <div>
      {{ reviews }}
    </div>
  </div>
</template>
