<script setup lang="ts">
import { useItemDelete } from "@/composables/hardware/use-item-delete";
import { useItemFetch } from "@/composables/hardware/use-item-fetch";

const router = useRouter();
const route = useRoute();

const { item, loading: fetching, fetchItem } = useItemFetch();

const gotoHardware = () => router.push({ name: "Hardware" });
const gotoHardwareItem = (code: string) =>
  router.push({ name: "HardwareItem", params: { code } });

const { deleteItem, loading, isDeleted } = useItemDelete();

const deleteItemHandler = async () => {
  if (item.value) {
    await deleteItem(item.value?.code);
    if (isDeleted) {
      gotoHardware();
    }
  }
};

watchEffect(async () => {
  if (route.params.code) {
    await fetchItem(route.params.code as string);
  }
});
</script>

<template>
  <div flex="1 ~ col gap-3" w="full">
    <template v-if="item">
      <div flex="~ gap-4" justify="between">
        <div flex="~ gap-2">
          <NButton @click="gotoHardware">Go back</NButton>
          <NButton @click="gotoHardwareItem('N82E16819113664')">
            Ryzen 9
          </NButton>
          <NButton @click="gotoHardwareItem('BX8071512900K')">
            Intel i9
          </NButton>
          <NButton @click="gotoHardwareItem('nepostojeci')">404</NButton>
        </div>
        <div>
          <NPopconfirm :show-icon="false" @positive-click="deleteItemHandler">
            <template #activator>
              <NButton class="visible" type="error">Delete</NButton>
            </template>
            Delete this item?
          </NPopconfirm>
        </div>
      </div>
      <NSpin :show="loading">
        <div flex="~ col-reverse lg:row gap-4">
          <HardwareDetails :item="item" />
          <HardwarePriceMessage :price="item.price" class="lg:flex-[500px]" />
        </div>
      </NSpin>
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
  </div>
</template>
