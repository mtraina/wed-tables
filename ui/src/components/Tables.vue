<template>
  <div class="fluid container">
    <div class="form-group form-group-lg panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Wedding tables</h3>
        <div class = "checkbox">
          <label><input type = "checkbox" v-model="editable">Enable drag and drop</label>      
        </div>
      </div>
    </div>

    <div  class="col-md-2">
        <draggable class="list-group" element="ul" v-model="list" :options="dragOptions" :move="onMove" @start="isDragging=true" @end="isDragging=false"> 
          <transition-group type="transition" :name="'flip-list'">
            <li class="list-group-item" v-for="element in list" :key="element.order"> 
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li> 
          </transition-group>
      </draggable>
    </div>

     <div  class="col-md-2">
      <draggable element="span" v-model="list2" :options="dragOptions" :move="onMove"> 
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in list2" :key="element.order"> 
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li> 
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">
      <draggable element="span" v-model="list3" :options="dragOptions" :move="onMove"> 
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in list3" :key="element.order"> 
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li> 
          </transition-group>
      </draggable>
    </div>


    <div  class="list-group col-md-2">
      <pre>{{listString}}</pre>
    </div>
     <div  class="list-group col-md-2">
      <pre>{{list2String}}</pre>
    </div>
  </div>
</template>

<script>
import draggable from 'vuedraggable'

const message = [ 'joe', 'alice', 'bob', 'charlie', 'david', 'erika' , 'frederik', 'george' ]
const message2 = []

export default {
  name: 'hello',
  components: {
    draggable,
  },
  data () {
    return {
      list: message.map( (name,index) => {return {name, order: index+1, fixed: false}; }),
      list2:[],
      list3:[],

      editable:true,
      isDragging: false,
      delayedDragging:false
    }
  },
  methods:{
    orderList () {
      this.list = this.list.sort((one,two) =>{return one.order-two.order; })
    },
    onMove ({relatedContext, draggedContext}) {
      const relatedElement = relatedContext.element;
      const draggedElement = draggedContext.element;
      return (!relatedElement || !relatedElement.fixed) && !draggedElement.fixed
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
    listString(){
      return JSON.stringify(this.list, null, 2);  
    },
    list2String(){
      return JSON.stringify(this.list2, null, 2);  
    }
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
    }
  }
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