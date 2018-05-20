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

    <!-- <table/> -->

     <div  class="col-md-2">Table 1
      <draggable element="span" v-model="table1" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table1" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 2
      <draggable element="span" v-model="table2" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table2" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 3
      <draggable element="span" v-model="table3" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table3" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 4
      <draggable element="span" v-model="table4" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table4" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 5
      <draggable element="span" v-model="table5" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table5" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

        <div  class="col-md-2">Table 6
      <draggable element="span" v-model="table6" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table6" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 7
      <draggable element="span" v-model="table7" :options="dragOptions" :move="onMove">
          <transition-group name="no" class="list-group" tag="ul">
            <li class="list-group-item" v-for="element in table7" :key="element.order">
              <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
              {{element.name}}
              <span class="badge">{{element.order}}</span>
            </li>
          </transition-group>
      </draggable>
    </div>

   <div  class="col-md-2">Table 8
     <draggable element="span" v-model="table8" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table8" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 9
     <draggable element="span" v-model="table9" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table9" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 10
     <draggable element="span" v-model="table10" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table10" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 11
     <draggable element="span" v-model="table11" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table11" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 12
     <draggable element="span" v-model="table12" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table12" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 13
     <draggable element="span" v-model="table13" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table13" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 14
     <draggable element="span" v-model="table14" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table14" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 15
     <draggable element="span" v-model="table15" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table15" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

    <div  class="col-md-2">Table 16
     <draggable element="span" v-model="table16" :options="dragOptions" :move="onMove">
        <transition-group name="no" class="list-group" tag="ul">
          <li class="list-group-item" v-for="element in table16" :key="element.order">
            <i :class="element.fixed? 'fa fa-anchor' : 'glyphicon glyphicon-pushpin'" @click=" element.fixed=! element.fixed" aria-hidden="true"></i>
            {{element.name}}
            <span class="badge">{{element.order}}</span>
          </li>
        </transition-group>
      </draggable>
    </div>

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
//import Table from './Table'

import guests from '../../data/guests.json'
//import fs from 'fs'
const fs = require('fs')
console.log(fs)
//console.log(guests);

export default {
  name: 'tables',
  components: {
    draggable,
  },
  data () {
    return {
      list: guests.filter(e => e.presence).map((e, index) => { return {name:e.name, order: index+1, fixed: false} }),
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
      // let data = JSON.stringify(table, null, 2);
      // console.log(data)

      // fs.writeFile('../../data/table-1.json', data, (err) => {
      //   if (err) throw err;
      //     console.log('Data written to file');
      // });

      console.log('This is before the write call');

      localStorage.setItem("guests", JSON.stringify(this.guests));
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
