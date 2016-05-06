<script type="text/javascript" language="javascript">
    $(function () {
        <#list 1..7 as x>
            $('#dot${x}').dotdotdot({
                watch: "window"
            });
        </#list>
    });
</script>