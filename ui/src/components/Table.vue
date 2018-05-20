<template>
  <div  class="col-md-2">Table {{ title }}
    <draggable element="span" v-model="elems" :options="dragOptions" :move="onMove"> 
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in elems" :key="element.order"> 
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li> 
        </transition-group>
    </draggable>
  </div>
</template>

<script>
import draggable from 'vuedraggable'
import { EventBus } from './event-bus.js'

export default {
  props: {
    tableId: String,
    title: String
  },
  components: {
    draggable,
  },
  data () {
    return {
      elems:[],
      
      editable:true,
      isDragging: false,
      delayedDragging:false
    }
  },
  created(){
    EventBus.$on('save', this.save);
  },
  mounted() {
    console.log(`tableId is: ${this.tableId}`)
    console.log(`title is: ${this.title}`)

    if(localStorage.getItem(this.tableId)){
      this.elems = JSON.parse(localStorage.getItem(tableId))
    } else {
      this.elems = []
    }
  },
  methods:{
    onMove ({relatedContext, draggedContext}) {
      const relatedElement = relatedContext.element;
      const draggedElement = draggedContext.element;
      return (!relatedElement || !relatedElement.fixed) && !draggedElement.fixed
    },
    save() {
      console.log('save dispatched')
      // console.log('This is before the write call');
      localStorage.setItem(this.tableId, JSON.stringify(this.elems));
      // console.log('This is after the write call');
    }
  },
  computed: {
    dragOptions () {
      return  {
        animation: 0,
        group: 'description',
        disabled: !this.editable,
        ghostClass: 'ghost'
      };
    },
  },
  watch: {
    isDragging (newValue) {
      if (newValue){
        this.delayedDragging= true
        return
      }
      this.$nextTick( () =>{
           this.delayedDragging =false
      })
    },

  },
}
</script>

<style>
.flip-list-move {
  transition: transform 0.5s;
}
.no-move {
  transition: transform 0s;
}
.ghost {
  opacity: .5;
  background: #C8EBFB;
}
.list-group {
  min-height: 20px;
}
.list-group-item {
  cursor: move;
}
.list-group-item i{
  cursor: pointer;
}
</style>