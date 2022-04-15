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
  <div overflow="y-auto x-hidden" p="r-2">
    <TransitionGroup
      name="list"
      tag="ul"
      flex="~ col"
      space="y-2"
      max-h="lg:75vh"
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
</template>

<style>
/* TODO */
.list-move, /* apply transition to moving elements */
.list-enter-active,
.list-leave-active {
  transition: all 0.5s ease;
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
