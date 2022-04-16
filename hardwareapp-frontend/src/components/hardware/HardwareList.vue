<script setup lang="ts">
import type { HardwareDTO } from "@/models/hardware";

type Props = {
  items: HardwareDTO[];
};

defineProps<Props>();

const router = useRouter();

const gotoHardwareItem = ({ code }: HardwareDTO) =>
  router.push({
    name: "HardwareItem",
    params: { code },
  });
</script>

<template>
  <n-scrollbar max-h="lg:75vh" p="r-2">
    <div p="r-2">
      <TransitionGroup
        name="list"
        tag="ul"
        flex="~ col"
        space="y-2"
        class="relative"
      >
        <HardwareListItem
          v-for="item in items"
          :key="item.code"
          :item="item"
          @click="gotoHardwareItem(item)"
          w="full"
        />
      </TransitionGroup>
    </div>
  </n-scrollbar>
</template>

<style>
/* TODO */
.list-move, /* apply transition to moving elements */
.list-enter-active,
.list-leave-active {
  transition: all 400ms ease;
  transform: translateX(0);
}

.list-enter-from,
.list-leave-to {
  opacity: 0;
  transform: translateY(1rem);
}

/* ensure leaving items are taken out of layout flow so that moving
   animations can be calculated correctly. */
.list-leave-active {
  position: absolute;
}
</style>
