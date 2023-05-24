public class HMAC_SSHA_1 {
   
    public String hmac_ssha_1(boolean [] k, String m )
    {
        

        Shendrrimet s=new Shendrrimet();
        Simplified_SHA_1 sa=new Simplified_SHA_1();
        m=s.strToBinary(m);
        
        // llogaritja e k'
        boolean [] k1=new boolean[32];
        if(k.length==k1.length)
        {
            for(int i=0; i<k1.length; i++)
            {k1[i]=k[i];}
        } 
        else{
            String b=s.boolean_string(k);
            String hash_b=sa.hash(b);
            k1=s.hex_boolean(hash_b);
        }
        // ipad 0x36  00110110 perseritet 4 here per te arritur gjatesine e bllokut 32. 
        boolean [] ipad={false,false,true,true,false,true,true,false,false,false,true,true,false,true,true,false,false,false,true,true,false,true,true,false,false,false,true,true,false,true,true,false};
        
        // opad 0x5C  01011100 perseritet 4 here per te arritur gjatesine e bllokut 32.
        boolean [] opad={false,true,false,true,true,true,false,false,false,true,false,true,true,true,false,false,false,true,false,true,true,true,false,false,false,true,false,true,true,true,false,false};
        
        // rez pas K' xor opad
        String k_opad=xor_to_String(k1, opad);
        
        //String per (K'xor opad)|| m
        String k_opad_m=k_opad+m;

        // H((K'xor opad)|| m)
        String h_k_opad_m=s.hex_binary(sa.hash(k_opad_m));

        // K' xor ipad
        String k_ipad=xor_to_String(k1, ipad);

        //  (K' xor ipad) || H((K'xor opad)|| m)
        String to_hmac=k_ipad+h_k_opad_m;

        //  H((K' xor ipad) || H((K'xor opad)|| m))
        String hmac_ssha_1=sa.hash(to_hmac);
        
        return hmac_ssha_1;
    }

    public static String xor_to_String(boolean[] a, boolean[] b)
    {
        boolean[] c=new boolean[a.length];
        for(int i=0; i<c.length; i++)
        {
            c[i]=a[i]^c[i];
        } 
        String cc="";
        for(int i=0; i<c.length; i++)
        {
            if(c[i])
            {cc=cc+"1";}
            else{cc=cc+"0";}
        }

        return cc;
    }
    
}


