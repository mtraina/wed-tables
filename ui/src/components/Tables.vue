<template>
  <div class="fluid container">
    <div class="form-group form-group-lg panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Wedding tables</h3>
        <div class = "checkbox">
          <label><input type = "checkbox" v-model="editable">Enable drag and drop</label>
        </div>
        <button v-on:click="save()">Save</button>
      </div>
    </div>

    <div  class="col-md-2">
        <draggable class="list-group" element="ul" v-model="guestList" :options="dragOptions" :move="onMove" @start="isDragging=true" @end="isDragging=false">
          <transition-group type="transition" :name="'flip-list'">
            <li class="list-group-item" v-for="element in guestList" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <Table tableId="table01" title="1"/>
    <Table tableId="table02" title="2"/>
    <Table tableId="table03" title="3"/>
    <Table tableId="table04" title="4"/>
    <Table tableId="table05" title="5"/>
    <Table tableId="table06" title="6"/>
    <Table tableId="table07" title="7"/>
    <Table tableId="table08" title="8"/>
    <Table tableId="table09" title="9"/>
    <Table tableId="table10" title="10"/>
    <Table tableId="table11" title="11"/>
    <Table tableId="table12" title="12"/>
    <Table tableId="table13" title="13"/>
    <Table tableId="table14" title="14"/>
    <Table tableId="table15" title="15"/>
    <Table tableId="table16" title="16"/>
    
  </div>
</template>

<script>
import draggable from 'vuedraggable'
import Table from './Table'
import { EventBus } from './event-bus.js'

import guests from '../../data/guests.json'
//import fs from 'fs'
const fs = require('fs')
console.log(fs)
//console.log(guests);

export default {
  name: 'tables',
  components: {
    draggable,
    Table
  },
  data() {
    return {
      guestList:[],

      editable:true,
      isDragging: false,
      delayedDragging:false
    }
  },
  mounted() {
      console.log('App mounted!');

      if(localStorage.getItem('guestList')){
        this.guestList = JSON.parse(localStorage.getItem("guestList"))
      } else {
        this.guestList = guests.filter(e => e.presence).map((e, index) => { return {name:e.name, order: index+1, fixed: false} });
      }
    },
  methods:{
    orderList () {
      this.list = this.list.sort((one,two) => { return one.order-two.order; })
    },
    onMove ({relatedContext, draggedContext}) {
      const relatedElement = relatedContext.element;
      const draggedElement = draggedContext.element;
      return (!relatedElement || !relatedElement.fixed) && !draggedElement.fixed
    },
    save() {
      console.log('This is before the write call');

      localStorage.setItem("guestList", JSON.stringify(this.guestList));
      EventBus.$emit('save');

      console.log('This is after the write call');
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
