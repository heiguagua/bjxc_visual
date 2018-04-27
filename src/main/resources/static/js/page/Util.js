define([],function(){
  var util = {
    /**
     * 生成32位uuid
     * @return {String} XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX
     */
    guid:function() {
        let result = ''
        for (let i = 1; i <= 16; i++) {
            let n = Math.floor(Math.random() * 16.0).toString(16)
            result += n
            if (i === 8 || i === 12) result += '-'
        }
        return result
    }
  }

  return util 
})