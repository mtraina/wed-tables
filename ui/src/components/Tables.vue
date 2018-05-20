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

    <!-- <div  class="list-group col-md-2">
      <pre>{{listString}}</pre>
    </div>
     <div  class="list-group col-md-2">
      <pre>{{list2String}}</pre>
    </div> -->
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
      table1:[],
      table2:[],
      table3:[],
      table4:[],
      table5:[],
      table6:[],
      table7:[],
      table8:[],
      table9:[],
      table10:[],
      table11:[],
      table12:[],
      table13:[],
      table14:[],
      table15:[],
      table16:[],

      editable:true,
      isDragging: false,
      delayedDragging:false
    }
  },
  mounted() {
      console.log('App mounted!');

      if(localStorage.getItem('guestList')){
        this.guestList = JSON.parse(localStorage.getItem("guestList"));
        this.table1 = JSON.parse(localStorage.getItem("table1"));
        this.table2 = JSON.parse(localStorage.getItem("table2"));
        this.table3 = JSON.parse(localStorage.getItem("table3"));
        this.table4 = JSON.parse(localStorage.getItem("table4"));
        this.table5 = JSON.parse(localStorage.getItem("table5"));
        this.table6 = JSON.parse(localStorage.getItem("table6"));
        this.table7 = JSON.parse(localStorage.getItem("table7"));
        this.table8 = JSON.parse(localStorage.getItem("table8"));
        this.table9 = JSON.parse(localStorage.getItem("table9"));
        this.table10 = JSON.parse(localStorage.getItem("table10"));
        this.table11 = JSON.parse(localStorage.getItem("table11"));
        this.table12 = JSON.parse(localStorage.getItem("table12"));
        this.table13 = JSON.parse(localStorage.getItem("table13"));
        this.table14 = JSON.parse(localStorage.getItem("table14"));
        this.table15 = JSON.parse(localStorage.getItem("table15"));
        this.table16 = JSON.parse(localStorage.getItem("table16"));
      } else {
        this.guestList = guests.filter(e => e.presence).map((e, index) => { return {name:e.name, order: index+1, fixed: false} });
        this.table1 = []
        this.table2 = []
        this.table3 = []
        this.table4 = []
        this.table5 = []
        this.table6 = []
        this.table7 = []
        this.table8 = []
        this.table9 = []
        this.table10 = []
        this.table11 = []
        this.table12 = []
        this.table13 = []
        this.table14 = []
        this.table15 = []
        this.table16 = []
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
      localStorage.setItem("table1", JSON.stringify(this.table1));
      localStorage.setItem("table2", JSON.stringify(this.table2));
      localStorage.setItem("table3", JSON.stringify(this.table3));
      localStorage.setItem("table4", JSON.stringify(this.table4));
      localStorage.setItem("table5", JSON.stringify(this.table5));
      localStorage.setItem("table6", JSON.stringify(this.table6));
      localStorage.setItem("table7", JSON.stringify(this.table7));
      localStorage.setItem("table8", JSON.stringify(this.table8));
      localStorage.setItem("table9", JSON.stringify(this.table9));
      localStorage.setItem("table10", JSON.stringify(this.table10));
      localStorage.setItem("table11", JSON.stringify(this.table11));
      localStorage.setItem("table12", JSON.stringify(this.table12));
      localStorage.setItem("table13", JSON.stringify(this.table13));
      localStorage.setItem("table14", JSON.stringify(this.table14));
      localStorage.setItem("table15", JSON.stringify(this.table15));
      localStorage.setItem("table16", JSON.stringify(this.table16));

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
