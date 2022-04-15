<script setup lang="ts">
import { useHardwareStore } from "@/stores/hardware";
import type { HardwareDTO } from "@/models/hardware";
import { set } from "@vueuse/core";

const store = useHardwareStore();
const router = useRouter();
const { params } = useRoute();
const code = params.code as string;
const loading = ref(false);
const hardwareItem = ref<HardwareDTO>();

watchEffect(async () => {
  console.log("code :>> ", code);
  if (code) {
    set(loading, true);
    const data = await store.fetchHardwareByCode(code);
    set(loading, false);
    set(hardwareItem, data);
  }
});

const gotoHardware = () => router.push({ name: "Hardware" });
</script>

<template>
  <div flex="1 ~ col gap-3" w="full">
    <div v-if="!loading && hardwareItem">
      <NButton @click="gotoHardware">Go back</NButton>
    </div>
    <div v-if="hardwareItem" flex="~ col-reverse lg:row gap-4">
      <HardwareDetails :item="hardwareItem" />
      <HardwarePriceMessage
        :price="hardwareItem.price"
        class="lg:flex-[500px]"
      />
    </div>
    <div
      v-else-if="!loading"
      class="grid place-content-center -translate-y-[8vh]"
      flex="1"
    >
      <n-result
        status="404"
        title="Item not found"
        description="Gone but not forgotten"
      >
        <template #footer>
          <n-button @click="gotoHardware"> Find something else</n-button>
        </template>
      </n-result>
    </div>
  </div>
</template>
